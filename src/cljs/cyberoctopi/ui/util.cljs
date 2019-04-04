(ns cyberoctopi.ui.util
  (:require [re-frame.core :as re-frame]))


(def <sub (comp deref re-frame/subscribe))
(def disp> re-frame/dispatch)
