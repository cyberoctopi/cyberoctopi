(ns cyberoctopi.ui.subs
  (:require [re-frame.core :as re-frame]
            [cyberoctopi.db :as db]))

(re-frame/reg-sub
 ::tableau
 (fn [db _]
   db/default-db))

(+ 3 3)
(pr-str ::tableau)
