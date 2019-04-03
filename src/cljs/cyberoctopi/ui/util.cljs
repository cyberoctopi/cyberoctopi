(ns cyberoctopi.ui.util
  (:require [re-frame.core :as re-frame]))


(def <== (comp deref re-frame/subscribe))
(def ==> re-frame/dispatch)
