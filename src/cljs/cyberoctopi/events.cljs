(ns cyberoctopi.events
  (:require
   [cyberoctopi.db :as db]
   [re-frame.core :as re-frame]))

;; (re-frame/reg-event-fx
;;  ::initialize-db
;;  (fn [_ _]
;;    db/default-db))

(re-frame/reg-event-db ::initialize-db (constantly db/default-db))
