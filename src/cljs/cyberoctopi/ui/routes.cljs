(ns cyberoctopi.ui.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]))

;; (def root-route
;;   [""
;;    {:name ::root
;;     :controllers
;;     [{:start
;;       (fn [& params]
;;         (-> ))}]}])


(def router
  [rf/router
   [["/" :index]
    ["/about" :about]]])

(defn path-for [route & [params]]
  (if params
    (:path (rf/match-by-name router route params))
    (:path (rf/match-by-name router route)))) 


(defn about-view []
  (fn [] [:h1 "About Jamal!"]))


(defn page-for [route]
  (case route
    :index #'page-index/render
    :about #'page-about/render))

(def current-page page-index/render)
