(ns cyberoctopi.ui.views
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch] :as re-frame]
  ;;          [cyberoctopi.ui.subs :as subs]
            [cyberoctopi.ui.util :refer [<sub disp>]]
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

(defn search-component 
  "search"
  []
  (fn []
    [:div (str "Search")]))

;; (defn breadcrumbs-component
;;   "Breadcrumbs to notify where you are in the system"
;;   []
;;   (fn []
;;     [:div.#breadcrumb-component (str "Front Page >")]))

(defn navigation []
  "Main navigation for Cyberoctopi sections"
  (fn []
    [:div#navi
     [:ul
            [:li
             [:a "Journal"]]
            [:li
             [:a "Blurbs"]]
            [:li
             [:a "About Me"]]
            [:li
             [:a "Art"]]
            [:li
             [:a "Reading List"]]]])) ;; TODO break this part off and create a menu system once I have a few dedicated sections to link to


(defn books-component []
  (fn []
    [:div#book-sidebar
     [:div
      [:div (str "Neuromancer")]
      [:div (str "Mona Lisa Overdrive")]
      [:div (str "Neuromancer")]
      [:div (str "Neuromancer")]
      [:div (str "Neuromancer")]]]))


(defn front-panel-content []
  [:div.container 
   [:div#content
    (str "So this is where the main block will show summaries and lists of posts/blurbs etc made by me")]
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



(defn main-view []
  "Foundation for web UI"
   (fn []
      [:div 
       [header]

       [front-panel-content]
       [data-tableau]
       ]))
