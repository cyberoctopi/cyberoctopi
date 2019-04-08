(ns cyberoctopi.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [cyberoctopi.config :as config]
            [cyberoctopi.events :as events]
            [cyberoctopi.ui.views :as ui]))

(defn dev-setup []
  (when config/debug? 
    (enable-console-print!)
    (println "dev mode")))


(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [ui/main-view]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (println "Initializing Cyberoctopi")
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  )


;; TODO set up a function to fire off figwheel and cljs-repl in one call
