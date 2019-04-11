(ns cyberoctopi.ui.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]))

(def root-route
  [""
   {:name ::root
    :controllers
    [{:start
      (fn [& params]
        (-> ))}]}])


(def routes
  [rf/router
   ["/"
    root-route
    front-page/routes]])
