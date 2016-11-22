(ns functional-programing-in-scala.ch3.ex3
  (:require [clojure.core.match :refer [match]]))

;; 예제
(defn sum [ints]
  (match ints
    [] 0
    [x & xs] (+ x (sum xs))))

(defn product [ds]
  (match ds
    [] 1.0
    [0.0 & _] 0.0
    [x & xs] (* x (product xs))))

(defn apply [as]
  (when (seq as)
    (cons (first as) (apply (rest as)))))

;; ex 3.1
;; => 3

;; ex 3.2
(defn tail [l]
  (match l
    nil nil
    [x & xs] xs))

;; ex 3.3
(defn set-head [l e]
  (match l
    [x & xs] (cons e xs)))

;; ex 3.4
(defn drop [l n]
  (if (zero? n)
    l
    (drop (tail l) (dec n))))

;; ex 3.5
(defn drop-while [l f]
  (if (f (first l))
    l
    (drop-while (tail l) f)))

;;
(defn append [a1 a2]
  (match a1
    [] a2
    [h & t] (cons h (append t a2))))

;; ex 3.6 ???
(defn init [l]
  )

;; 목록 3.2
(defn fold-right [as z f]
  (match as
    [] z
    [x & xs] (f x (fold-right xs z f))))

(defn product2 [ns]
  (fold-right ns 1.0 #(* %1 %2)))






