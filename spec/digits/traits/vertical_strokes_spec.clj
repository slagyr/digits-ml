(ns digits.traits.vertical-strokes-spec
  (:require [speclj.core :refer :all]
            [digits.samples :refer [samples]]
            [digits.trait :as traits]
            [digits.traits.vertical-strokes :refer :all]
            [digits.data :as data]
            [digits.classify :as classify]))

(defn vertical-strokes-for [image]
  (:vertical-strokes (traits/build-personality [vertical-strokes] image)))

(describe "Vertical Strokes"

  (it "0's vertical strokes"
    (should= [2 2 2] (map vertical-strokes-for (:0 samples))))

  (it "1's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:1 samples))))

  (it "2's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:2 samples))))

  (it "3's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:3 samples))))

  (it "4's vertical strokes"
    (should= [3 2 2] (map vertical-strokes-for (:4 samples))))

  (it "5's vertical strokes"
    (should= [1 0 2] (map vertical-strokes-for (:5 samples))))

  (it "6's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:6 samples))))

  (it "7's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:7 samples))))

  (it "8's vertical strokes"
    (should= [4 4 4] (map vertical-strokes-for (:8 samples))))

  (it "9's vertical strokes"
    (should= [1 1 1] (map vertical-strokes-for (:9 samples))))

  ;(it "cross validattion"
  ;  (let [strategy (classify/create-classification-strategy [vertical-strokes]
  ;                                                          [:lazy :ibk]
  ;                                                          (data/training-data))
  ;        validation (classify/cross-validate strategy 3)]
  ;    (println validation)
  ;    (should (> (:percentage-correct validation) 50))))

  )

;{:average-cost 0.0, :incorrect 29811.0, :roc-area {:0 0.8484898112728875, :4 0.729209424671459, :7 0.7125549316297438, :1 0.7474515891649951, :8 0.8778792366953228, :9 0.6255779359220619, :2 0.5978973251483981, :5 0.7224745500445813, :3 0.6719272885055643, :6 0.6102169864457518}, :false-positive-rate {:0 0.23922573148832788, :4 0.0, :7 0.0, :1 0.4912638010504877, :8 0.004217518517542241, :9 0.0, :2 3.9658408904634745E-4, :5 0.02101819133621254, :3 0.0, :6 0.03808467369199482}, :unclassified 0.0, :sf-entropy-gain 24838.071080728216, :kb-mean-information 0.7600040204939786, :kb-information 31920.168860747104, :percentage-incorrect 70.97857142857143, :root-relative-squared-error 94.02130128253627, :precision {:0 0.2927629010851745, :4 0.0, :7 0.0, :1 0.20125484728334278, :8 0.9340478153338829, :9 0.0, :2 0.11764705882352941, :5 0.5371757925072046, :3 0.0, :6 0.3006789524733269}, :error-rate 0.7097857142857142, :percentage-unclassified 0.0, :recall {:0 0.9075508228460794, :4 0.0, :7 0.0, :1 0.9861229718189581, :8 0.5577159734186562, :9 0.0, :2 4.7881254488867607E-4, :5 0.2455862977602108, :3 0.0, :6 0.14986705342035292}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.159047654149243, :summary
;Correctly Classified Instances       12189               29.0214 %
;Incorrectly Classified Instances     29811               70.9786 %
;Kappa statistic                          0.2068
;Mean absolute error                      0.159
;Root mean squared error                  0.282
;Relative absolute error                 88.388  %
;Root relative squared error             94.0213 %
;Coverage of cases (0.95 level)          97.5738 %
;Mean rel. region size (0.95 level)      74.5536 %
;Total Number of Instances            42000
;, :kb-relative-information 961488.1367730421, :false-negative-rate {:0 0.09244917715392062, :4 1.0, :7 1.0, :1 0.013877028181041844, :8 0.44228402658134386, :9 1.0, :2 0.9995211874551113, :5 0.7544137022397892, :3 1.0, :6 0.8501329465796471}, :relative-absolute-error 88.38796303388591, :root-mean-squared-error 0.2820189605952922, :sf-mean-entropy-gain 0.5913826447792432, :evaluation-object #<Evaluation weka.classifiers.Evaluation@3c0209f2>, :confusion-matrix === Confusion Matrix ===
;
;    a    b    c    d    e    f    g    h    i    j   <-- classified as
; 3750  152    3    0    0   29  180    0   18    0 |    a = 0
;   58 4619    0    0    0    5    0    0    2    0 |    b = 1
;  927 2971    2    0    0  122  125    0   30    0 |    c = 2
;  621 3222    0    0    0  492   13    0    3    0 |    d = 3
; 2704  995    1    0    0   15  326    0   31    0 |    e = 4
;  454 2389    0    0    0  932   18    0    2    0 |    f = 5
; 1126 2345    5    0    0   19  620    0   22    0 |    g = 6
;  274 4067    0    0    0   44   15    0    1    0 |    h = 7
; 1175  305    3    0    0   57  257    0 2266    0 |    i = 8
; 1720 1886    3    0    0   20  508    0   51    0 |    j = 9
;, :kappa 0.20681676167756338, :f-measure {:0 0.4427129449265097, :4 0.0, :7 0.0, :1 0.3342862312285146, :8 0.6984126984126985, :9 0.0, :2 9.537434430138292E-4, :5 0.3370705244122965, :3 0.0, :6 0.20003226326826912}, :percentage-correct 29.021428571428572, :correct 12189.0}
