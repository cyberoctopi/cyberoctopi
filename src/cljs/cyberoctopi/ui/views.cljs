(ns cyberoctopi.ui.views
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch] :as re-frame]
  ;;          [cyberoctopi.ui.subs :as subs]
            [cyberoctopi.ui.util :refer [<== ==>]]
            [cyberoctopi.db :as db]))


(defn- panels [panel-name logged-in?]
  "Panels for each major section"
  (case panel-name
    :front-page-panel []
    :user-panel [] ;; NOTE: This is where you'll manage and create your content or have a broad admin overview
    :book-panel []
    :journal-panel []
    :portfolio-panel []
    :about-panel []
    :login-pane []
    :register-panel [] ;; NOTE: For the moment this site is for me but later on add a registration panel for friends
    ))



(defn show-panel [panel-name logged-in?]
  [panels panel-name logged-in?])



(defn navigation []
  "Main navigation for Cyberoctopi sections"
  (fn []
    [:div#navi
     [:div [:ul
            [:li
             [:a "Journal"]]
            [:li
             [:a "Blurbs"]]
            [:li
             [:a "About Me"]]
            [:li
             [:a "Art"]]
            [:li
             [:a "Reading List"]]]]])) ;; TODO break this part off and create a menu system once I have a few dedicated sections to link to




(defn header []
  "Main division for logo and navigation"
  (fn []
    [:header
     [:logo "Cyberoctopi"]
     [navigation]]))


(re-frame/reg-sub
 ::tableau
 (fn [db _]
   db/default-db))

(defn data-tableau []
  "Dashboard display for items in database"
  "Heads up display for the database. "
  (let [data (<== [::tableau])]
    (fn []
      [:div.data-tableau (pr-str data)])))



(defn main-view []
  "Foundation for web UI"
   (fn []
      [:div 
       [header]
       [data-tableau]
       ]))
