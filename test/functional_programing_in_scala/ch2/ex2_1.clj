(ns functional-programing-in-scala.ch2.ex2-1
  (:require [clojure.spec :as s]
            [clojure.spec.test :as t]))

;; ex 2.1
(defn fib [n]
  (loop [p 0
         r 1
         i 2]
    (condp = n
          0 0
          1 1
          i (+ p r)
          (recur r (+ p r) (inc i)))))

;; ex 2.2
(defn sorted-coll? [as ordered-fn?]
  (loop [coll (seq as)]
    (cond 
      (= 1 (count coll)) true
      (not (ordered-fn? (first coll) (second coll))) false
      :else (recur (rest coll)))))

;; ex 2.3
(defn curry [f]
  (fn [a]
    (fn [b]
      (f a b))))

;; ex 2.4
(defn uncurry [f]
  (fn [a b]
    ((f a) b)))

;; ex 2.5
(defn compose [f g]
  (fn [a]
    (f (g a))))
