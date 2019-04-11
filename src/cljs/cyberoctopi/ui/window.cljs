(ns cyberoctopi.ui.window
  (:require [reagent.core :as r]
            [cyberoctopi.ui.util :refer [<sub disp>]]))


(defn search-component 
  "search"
  []
  (fn []
    [:div (str "")]))


;; TODO: Fix navigation css and overall width of layout to be more responsive. Start thinking of mobile users now
(defn navigation []
  "Main navigation for cyberoctopi sections"
  (fn []
    [:div#navi
     [:ul
            [:li
             [:a "Journal"]]
            [:li
             [:a "About Me"]]
            [:li
             [:a "Art"]]
            [:li
             [:a "Reading List"]]]])) ;; TODO break this part off and create a menu system once I have a few dedicated sections to link to


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


(defn front-panel-content []
  [:div.container 
   [:div#content
    (str "Journal content goes here")]
   [books-component]
   ])


(defn header []
  "Main division for logo and navigation"
  (fn []
    [:header
     [:logo "Cyberoctopi"]
     [search-component]
     [navigation]

     ]))


(re-frame/reg-sub
 ::tableau
 (fn [db _]
   db/default-db))

(defn data-tableau []
  "Dashboard display for items in database"
  "Heads up display for the database. "
  (let [data (<sub [::tableau])]
    (fn []
      [:div.data-tableau (pr-str data)])))



(defn page-window []
  "Foundation for web UI"
   (fn []
      [:div 
       [header]

       [front-panel-content]
       [data-tableau]
       ]))


