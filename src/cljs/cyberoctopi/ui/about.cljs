(ns cyberoctopi.ui.about
  (:require [reagent.core :as reagent :refer [atom]]
            [reitit.frontend :as rf]
            [cyberoctopi.ui.window :refer [window-layout]]))

(defn about-panel []
  (fn []
    [:div.container
     [:div#content
      (str "About me")]]))

(defn render []
  (window-layout [about-panel]))
