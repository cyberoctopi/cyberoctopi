(ns cyberoctopi.ui.front
  (:require [reagent.core :as reagent :refer [atom]]
            [reitit.frontend :as rf]
            [cyberoctopi.ui.window :refer [window-layout]]))


(defn books-component []
  (fn []
    [:div#book-sidebar
     [:div.current
      [:div.vertical (str "Current & Latest Reads")]]
     [:div [:img.book-item {:src (str "img/books/neuro.png")}]]
     [:div [:img.book-item {:src (str "img/books/mona.png")}]]
     [:div [:img.book-item {:src (str "img/books/geb.png")}]]
     [:div [:img.book-item {:src (str "img/books/1q84.png")}]]
     [:div [:img.book-item {:src (str "img/books/kill.png")}]]]))


(defn front-panel []
  [:div.container 
   [:div#content
    (str "Journal content goes here")]
   [books-component]])


(defn render []
  (window-layout [front-panel]))
