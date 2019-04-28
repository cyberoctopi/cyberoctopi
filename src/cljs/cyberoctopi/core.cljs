(ns cyberoctopi.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [re-frame.core :as re-frame]
            [reitit.frontend :as rf]
            [clerk.core :as clerk]
            [accountant.core :as accountant]
            [cyberoctopi.config :as config]
            [cyberoctopi.events :as events]
            [cyberoctopi.ui.routes :as routes]
            [cyberoctopi.ui.front :as front-panel]))


(defn dev-setup []
  (when config/debug? 
    (enable-console-print!)
    (println "dev mode")))

;;(def current-page front-panel/render)

(defn mount-root []
;  (re-frame/clear-subscription-cache!)
  (reagent/render [current-page]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (println "Initializing Cyberoctopi")
  (clerk/initialize!)
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (let [match (rf/match-by-path routes/router path)
            current-page (:name (:data match))
            route-params (:path-params match)]
        (reagent/after-render clerk/after-render!)
        (session/put! :route {:current-page (routes/page-for current-page)
                              :route-params route-params}) ;; NOTE: Session
        (clerk/navigate-page! path)
        ))
    :path-exists?
    (fn [path]
      (booleans (rf/match-by-path routes/router path)))})
  (accountant/dispatch-current!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (mount-root)
  (dev-setup))
