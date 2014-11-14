(ns digits.traits.horizontal-strokes-spec
  (:require [speclj.core :refer :all]
            [digits.samples :refer [samples]]
            [digits.trait :as traits]
            [digits.traits.horizontal-strokes :refer :all]
            [digits.data :as data]
            [digits.classify :as classify]))

(defn horizontal-strokes-for [image]
  (:horizontal-strokes (traits/build-personality [horizontal-strokes] image)))

(describe "Horizontal Strokes"

  ;(it "0's horizontal strokes"
  ;  (should= [2 2 2] (map horizontal-strokes-for (:0 samples))))
  ;
  ;(it "1's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:1 samples))))
  ;
  ;(it "2's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:2 samples))))
  ;
  ;(it "3's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:3 samples))))
  ;
  ;(it "4's horizontal strokes"
  ;  (should= [3 2 2] (map horizontal-strokes-for (:4 samples))))
  ;
  ;(it "5's horizontal strokes"
  ;  (should= [1 0 2] (map horizontal-strokes-for (:5 samples))))
  ;
  ;(it "6's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:6 samples))))
  ;
  ;(it "7's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:7 samples))))
  ;
  ;(it "8's horizontal strokes"
  ;  (should= [4 4 4] (map horizontal-strokes-for (:8 samples))))
  ;
  ;(it "9's horizontal strokes"
  ;  (should= [1 1 1] (map horizontal-strokes-for (:9 samples))))

  ;(it "cross validattion"
  ;  (let [strategy (classify/create-classification-strategy [horizontal-strokes]
  ;                                                          [:lazy :ibk]
  ;                                                          (data/training-data))
  ;        validation (classify/cross-validate strategy 3)]
  ;    (println validation)
  ;    (should (> (:percentage-correct validation) 50))))

  )

;{:average-cost 0.0, :incorrect 29123.0, :roc-area {:0 0.7424656537341564, :4 0.700193694991938, :7 0.7440810158024442, :1 0.9240061242368933, :8 0.6478708424658675, :9 0.6226304942938427, :2 0.7511667772276814, :5 0.711247198259028, :3 0.7283394423831606, :6 0.5626157983372633}, :false-positive-rate {:0 0.2805535016372663, :4 0.0, :7 0.21505891114125375, :1 0.08481616464787223, :8 0.0017924453699554525, :9 0.0, :2 0.010152552679586495, :5 0.14587095929852115, :3 0.03248426253021328, :6 0.0}, :unclassified 0.0, :sf-entropy-gain 22145.8290389717, :kb-mean-information 0.7321581870366574, :kb-information 30750.64385553961, :percentage-incorrect 69.3404761904762, :root-relative-squared-error 94.62455192341558, :precision {:0 0.22025688073394495, :4 0.0, :7 0.23012472626868513, :1 0.5502983802216539, :8 0.8260869565217391, :9 0.0, :2 0.6085626911314985, :5 0.22618717023049154, :3 0.4588495575221239, :6 0.0}, :error-rate 0.6934047619047619, :percentage-unclassified 0.0, :recall {:0 0.7262826718296225, :4 0.0, :7 0.5491933651442854, :1 0.8268573868488471, :8 0.0794979079497908, :9 0.0, :2 0.14292554464926982, :5 0.42924901185770753, :3 0.23833601470926224, :6 0.0}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.16106566218891732, :summary
;Correctly Classified Instances       12877               30.6595 %
;Incorrectly Classified Instances     29123               69.3405 %
;Kappa statistic                          0.2286
;Mean absolute error                      0.1611
;Root mean squared error                  0.2838
;Relative absolute error                 89.5094 %
;Root relative squared error             94.6246 %
;Coverage of cases (0.95 level)          97.5214 %
;Mean rel. region size (0.95 level)      81.5645 %
;Total Number of Instances            42000
;, :kb-relative-information 926259.7170083849, :false-negative-rate {:0 0.2737173281703775, :4 1.0, :7 0.4508066348557146, :1 0.17314261315115287, :8 0.9205020920502092, :9 1.0, :2 0.8570744553507302, :5 0.5707509881422925, :3 0.7616639852907378, :6 1.0}, :relative-absolute-error 89.50943584634865, :root-mean-squared-error 0.28382842415726256, :sf-mean-entropy-gain 0.5272816437850405, :evaluation-object #<Evaluation weka.classifiers.Evaluation@5fef248a>, :confusion-matrix === Confusion Matrix ===
;
;    a    b    c    d    e    f    g    h    i    j   <-- classified as
; 3001  240    7    9    0  290    0  584    1    0 |    a = 0
;   28 3873    0    2    0    2    0  779    0    0 |    b = 1
; 1333   59  597  291    0 1469    0  403   25    0 |    c = 2
; 1059  213   36 1037    0 1383    0  607   16    0 |    d = 3
;  835  434   57  221    0  202    0 2320    3    0 |    e = 4
; 1320  128   21   71    0 1629    0  618    8    0 |    f = 5
; 1463  766   22   28    0  616    0 1236    6    0 |    g = 6
; 1622  226   32   11    0   93    0 2417    0    0 |    h = 7
;  865  463  200  577    0  901    0  734  323    0 |    i = 8
; 2099  636    9   13    0  617    0  805    9    0 |    j = 9
;, :kappa 0.22860797926638385, :f-measure {:0 0.3380075463197612, :4 0.0, :7 0.3243424584004294, :1 0.6608087357106296, :8 0.1450381679389313, :9 0.0, :2 0.23148507173322994, :5 0.29626261707738477, :3 0.3137195583119044, :6 0.0}, :percentage-correct 30.659523809523808, :correct 12877.0}