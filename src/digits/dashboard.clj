(ns digits.dashboard
  (:require [seesaw.core :refer :all]))

(defn make-frame []
  (frame :title "Hello"
         ;:content "Hello, Seesaw",
         ;:on-close :exit
         :size [600 :by 400]))

(defn load-dashboard [& args]
  (let [frame (make-frame)]
    (.setAlwaysOnTop frame true)
    (invoke-later (show! frame))))

