(ns cyberoctopi.ui.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rc]
            [reitit.frontend.easy :as rfe]
            [cyberoctopi.ui.front :as panel-front]))


(def router
  [rf/router
   [["/" :index]
    ["/about" :about]]])


(defn path-for [route & [params]]
  (if params
    (:path (rf/match-by-name router route params))
    (:path (rf/match-by-name router route)))) 


(defn page-for [route]
  (case route
    :index #'panel-front/render
;    :about #'page-about/render
    ))


(def current-page panel-front/render)
