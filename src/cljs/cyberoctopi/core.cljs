(ns cyberoctopi.core
  (:require [reagent.core :as reagent]))

(defn dev-setup []
  (when config/defbug? 
    (enable-console-print!)
    (println "dev mode")))

(defn temp-view []
  [:h1 "Hello Cyberoctopi"])

(defn mount-root []
  (reagent/render [temp-view]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (println "Initializing Cyberoctopi"))
