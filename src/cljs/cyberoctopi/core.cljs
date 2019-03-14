(ns cyberoctopi.core
  (:require [reagent.core :as reagent]))

(enable-console-print!)

(defn temp-view []
  [:h1 "Hello Cyberoctopi"])

(defn mount-root []
  (reagent/render [temp-view]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (console.log "Initializing Cyberoctopi"))
