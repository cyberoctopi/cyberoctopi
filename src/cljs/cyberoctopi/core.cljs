(ns cyberoctopi.core
  (:require [reagent.core :as reagent]
            [cyberoctopi.config :as config]
            [cyberoctopi.ui.views :as ui]))

(defn dev-setup []
  (when config/debug? 
    (enable-console-print!)
    (println "dev mode")))


(defn mount-root []
  (reagent/render [ui/main-view]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (println "Initializing Cyberoctopi"))


;; TODO set up a function to fire off figwheel and cljs-repl in one call
