(ns functional-programing-in-scala.ch1.ex-1-1)

;; Coffee
(defn create-coffee []
  (fn [method]
    (case method
      :get-price (fn []
                   3000)
      nil)))

;; Charge
(defn create-charge [cc amount]
  (fn [method]
    (case method
      :get-cc (fn [] cc)
      :get-amount (fn [] amount)
      :combine (fn [other]
                 (if (= cc ((other :get-cc)))
                   (create-charge cc (+ amount ((other :get-amount))))
                   (throw (Exception. "Can't combine charges to different cards")))))))

;; Cafe
(defn create-cafe []
  (fn [method]
    (let [buy-coffee
          (fn [cc]
            (let [cup (create-coffee)]
              [cup (create-charge cc ((cup :get-price)))]))

          buy-coffees
          (fn [cc n]
            (let [purchases (repeat n (buy-coffee cc))]
              ))]
      (case method
        :buy-coffee buy-coffee
        :buy-coffees buy-coffees
        nil))))





















