(ns digits.traits.active-pixel-spec
  (:require [speclj.core :refer :all]))

  ; *****
  ;
  ;This is the technique used in the Kaggle example solutions.
  ;
  ;It treats each pixel as it's own trait (784 of them) and, despite being horribly CPU intesive, it's results are quite good.
  ;
  ;96% accuracy !!!
  ;
  ;We shall beat this.
  ;
  ; *****

(describe "Active Pixels"


  ;(it "cross validates active pixels"
  ;  (let [strategy (classify/create-classification-strategy (mapv (fn [i] (vector (keyword (str i)) #(nth % i))) (range 784))
  ;                                                          [:lazy :ibk]
  ;                                                          (data/training-data))
  ;        validation (classify/cross-validate strategy 3)]
  ;    (println validation)
  ;    (should (> (:percentage-correct validation) 50))
  ;    )
  ;  )

  ;Finished in 5832.17158 seconds
  ;{:average-cost 0.0, :incorrect 1480.0, :roc-area {:0 0.9950604514934488, :4 0.9763512988522561, :7 0.9825371630121201, :1 0.9940262309782293, :8 0.9617633398988988, :9 0.972114831725166, :2 0.9795373148915835, :5 0.9739681342538924, :3 0.9746257296504609, :6 0.991669539031381}, :false-positive-rate {:0 0.0023766768775747332, :4 0.0028475005273149124, :7 0.005159711694459959, :1 0.004475292099903527, :8 0.0018978833328940085, :9 0.0075372897492859406, :2 0.0021415540808502765, :5 0.004632901452689439, :3 0.00547159287099259, :6 0.0026411008108179488}, :unclassified 0.0, :sf-entropy-gain 117550.89123405154, :kb-mean-information 3.1964003946835375, :kb-information 134248.81657670857, :percentage-incorrect 3.5238095238095237, :root-relative-squared-error 27.982851979425615, :precision {:0 0.9785254115962777, :4 0.972993248312078, :7 0.9565412186379928, :1 0.9653239202657807, :8 0.9812108559498957, :9 0.9332708967454929, :2 0.980224609375, :5 0.9533227848101266, :3 0.9527522935779816, :6 0.9760708303421871}, :error-rate 0.035238095238095235, :percentage-unclassified 0.0, :recall {:0 0.9924975798644724, :4 0.9555500982318271, :7 0.9702340377187003, :1 0.9925277540563621, :8 0.9254245631306917, :9 0.9517669531996179, :2 0.9612161838640172, :5 0.9525691699604744, :3 0.9547230521719146, :6 0.9859801788735799}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.007109365702723353, :summary
  ;Correctly Classified Instances       40520               96.4762 %
  ;Incorrectly Classified Instances      1480                3.5238 %
  ;Kappa statistic                          0.9608
  ;Mean absolute error                      0.0071
  ;Root mean squared error                  0.0839
  ;Relative absolute error                  3.9509 %
  ;Root relative squared error             27.9829 %
  ;Coverage of cases (0.95 level)          96.4762 %
  ;Mean rel. region size (0.95 level)      10      %
  ;Total Number of Instances            42000
  ;, :kb-relative-information 4043786.8711792496, :false-negative-rate {:0 0.007502420135527589, :4 0.044449901768172886, :7 0.029765962281299706, :1 0.007472245943637917, :8 0.0745754368693084, :9 0.04823304680038205, :2 0.038783816135982765, :5 0.04743083003952569, :3 0.0452769478280855, :6 0.01401982112642011}, :relative-absolute-error 3.9509061374587926, :root-mean-squared-error 0.0839351798164855, :sf-mean-entropy-gain 2.7988307436678936, :evaluation-object #<Evaluation weka.classifiers.Evaluation@7dcfef46>, :confusion-matrix === Confusion Matrix ===
  ;
  ;    a    b    c    d    e    f    g    h    i    j   <-- classified as
  ; 4101    1    4    2    1    7   13    0    1    2 |    a = 0
  ;    0 4649    9    5    2    0    0    9    5    5 |    b = 1
  ;   26   27 4015   22    3    3    5   62   10    4 |    c = 2
  ;    3    5   25 4154    0   78    2   28   34   22 |    d = 3
  ;    3   36    0    0 3891    2   13    9    2  116 |    e = 4
  ;    8    4    1   70    6 3615   46    4   11   30 |    f = 5
  ;   24    6    0    2    7   17 4079    0    1    1 |    g = 6
  ;    0   42   21    2   10    0    0 4270    0   56 |    h = 7
  ;   15   37   19   79   15   61   19    9 3760   49 |    i = 8
  ;   11    9    2   24   64    9    2   73    8 3986 |    j = 9
  ;, :kappa 0.9608312588115134, :f-measure {:0 0.9854619728463295, :4 0.9641927889976459, :7 0.9633389734912577, :1 0.9787368421052631, :8 0.9525015832805573, :9 0.9424281830003546, :2 0.9706273419557596, :5 0.9529458283906683, :3 0.9537366548042705, :6 0.981000481000481}, :percentage-correct 96.47619047619048, :correct 40520.0}

  )

