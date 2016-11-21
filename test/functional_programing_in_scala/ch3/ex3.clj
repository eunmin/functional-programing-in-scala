(ns functional-programing-in-scala.ch3.ex3
  (:require [clojure.core.match :refer [match]]))


;; 예제

(defn sum [ints]
  (match ints
    [] 0
    [x & xs] (+ x (sum xs))))

