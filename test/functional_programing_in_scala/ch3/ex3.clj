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

;; ex 3.6
(defn init [l]
  (match l
    [x] nil
    [x & xs] (cons x (init xs))))

;; 목록 3.2
(defn fold-right [as z f]
  (match as
    [] z
    [x & xs] (f x (fold-right xs z f))))

(defn sum2 [ns]
  (fold-right ns 0 #(+ %1 %2)))

(defn product2 [ns]
  (fold-right ns 1.0 #(* %1 %2)))

;; ex 3.7
(product2 [1 2 3 0 1 2 3 4])
;; 0이 나와도 멈추지 않고 끝가지 수행된다

;; ex 3.8
(fold-right [1 2 3] nil #(cons %1 %2))

;;=> (cons 1 (cons 2 (cons 3 nil)))

;; ex 3.9
(defn length [as]
  (fold-right as 0 #(+ 1 %2)))

;; ex 3.10
(defn fold-left [as z f]
  (if (seq as)
    (fold-left (tail as) (f z (first as)) f)
    z))


;; ex 3.11
(defn sum3 [ns]
  (fold-left ns 0 #(+ %1 %2)))

(defn product3 [ns]
  (fold-left ns 1.0 #(* %1 %2)))

;; ex 3.12
(defn my-reverse [ns]
  (fold-left ns [] #(cons %2 %1)))

;; ex 3.14
(defn append2 [a1 a2]
  (fold-left a2 (my-reverse a1) #(cons %2 %1)))
