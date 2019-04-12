(ns cyberoctopi.ui.window
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]
            [cyberoctopi.db :as db]
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
             [:a "Book Work"]]
            [:li
             [:a "About Me"]]
            ]])) ;; TODO break this part off and create a menu system once I have a few dedicated sections to link to



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



(defn window-layout [dom]
  "Foundation for web UI"
   (fn []
      [:div 
       [header]
       ;; NOTE: So the only things that belong here are the header and possible a footer.
                                        ; [front-panel-content]
                                        ; [data-tableau]
       dom
       [data-tableau]
       ]))


