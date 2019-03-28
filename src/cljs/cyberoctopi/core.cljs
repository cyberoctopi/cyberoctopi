(ns cyberoctopi.core
  (:require [reagent.core :as reagent]
            [cyberoctopi.config :as config]))

(defn dev-setup []
  (when config/debug? 
    (enable-console-print!)
    (println "dev mode")))

(defn data-tableau []
  [:div.data-tableau (str "testing data tableau!")])

(defn temp-view []
  (fn []
    [:div 
     [data-tableau]
     [:h4 "Cyberoctopi:"]]))

(defn mount-root []
  (reagent/render [temp-view]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (println "Initializing Cyberoctopi"))


;; TODO set up a function to fire off figwheel and cljs-repl in one call
