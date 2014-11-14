(ns digits.traits.transition-count-spec
  (:require [speclj.core :refer :all]
            [digits.traits.transition-count :refer :all]))

(describe "Transition Count"

  (it "counts transitions form white to black"
    (should= 0 (count-transitions [0 0 0 0 0 0 0]))
    (should= 1 (count-transitions [0 0 0 255 0 0 0]))
    (should= 1 (count-transitions [0 0 0 1 0 0 0]))
    (should= 2 (count-transitions [0 0 0 1 0 1 0]))
    (should= 1 (count-transitions [0 0 0 1 1 1 0])))

  ;(it "cross validates transitions"
  ;      (let [strategy (classify/create-classification-strategy {:transition-count count-transitions}
  ;                                                              [:lazy :ibk {:num-neighbors 3}]
  ;                                                              (data/training-data))
  ;            validation (classify/cross-validate strategy 3)]
  ;        (println (.classifier strategy))
  ;        (println validation)
  ;        (should (> (:percentage-correct validation) 50))
  ;        ))

  )

; Summary: 33% is not terrible, but not great.  3x better than guessing.  *Might* be useful in combined classifier.

;using 1 nearest neighbour(s) for classification
;{:average-cost 0.0, :incorrect 27846.0, :roc-area {:0 0.9111134894780473, :4 0.7881891767630034, :7 0.740221272932543, :1 0.9555623807070118, :8 0.7432170649695142, :9 0.7027413801918121, :2 0.6488230801445268, :5 0.7416595721127908, :3 0.7088036485311325, :6 0.6240165562355193}, :false-positive-rate {:0 0.07071934086827929, :4 0.2013288335794136, :7 0.11492326923588393, :1 0.05490942223175046, :8 0.0, :9 0.14260023273035016, :2 5.023398461253734E-4, :5 0.011385944248135061, :3 0.14088023586283832, :6 3.169320972981539E-4}, :unclassified 0.0, :sf-entropy-gain 29217.409038469545, :kb-mean-information 0.8972997304904864, :kb-information 37686.58868060043, :percentage-incorrect 66.3, :root-relative-squared-error 92.54427207860994, :precision {:0 0.5137098238605411, :4 0.23594156493896337, :7 0.27597184986595175, :1 0.6759962049335864, :8 0.0, :9 0.18635883506865852, :2 0.4411764705882353, :5 0.5292207792207793, :3 0.19709355131698456, :6 0.25}, :error-rate 0.663, :percentage-unclassified 0.0, :recall {:0 0.6846563407550823, :4 0.5790766208251473, :7 0.37423312883435583, :1 0.9126814688300597, :8 0.0, :9 0.2948901623686724, :2 0.0035910940866650705, :5 0.12885375494071147, :3 0.29924155366582394, :6 9.668842156151801E-4}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.15394534358144518, :summary
;Correctly Classified Instances       14154               33.7    %
;Incorrectly Classified Instances     27846               66.3    %
;Kappa statistic                          0.2619
;Mean absolute error                      0.1539
;Root mean squared error                  0.2776
;Relative absolute error                 85.5524 %
;Root relative squared error             92.5443 %
;Coverage of cases (0.95 level)          96.5095 %
;Mean rel. region size (0.95 level)      69.6645 %
;Total Number of Instances            42000
;, :kb-relative-information 1135182.0224520294, :false-negative-rate {:0 0.3153436592449177, :4 0.4209233791748527, :7 0.6257668711656442, :1 0.08731853116994022, :8 1.0, :9 0.7051098376313276, :2 0.996408905913335, :5 0.8711462450592885, :3 0.700758446334176, :6 0.9990331157843848}, :relative-absolute-error 85.55244282289425, :root-mean-squared-error 0.2775885790203062, :sf-mean-entropy-gain 0.6956525961540367, :evaluation-object #<Evaluation weka.classifiers.Evaluation@5bda846e>, :confusion-matrix === Confusion Matrix ===
;
;    a    b    c    d    e    f    g    h    i    j   <-- classified as
; 2829    6    0   81 1021   13    7   35    0  140 |    a = 0
;    7 4275    0   47   20   12    0  303    0   20 |    b = 1
;  225  240   15  968  869  265    1  787    0  807 |    c = 2
;   57  325    0 1302  607   48    0 1083    0  929 |    d = 3
;  702   16    0  219 2358    5    3   96    0  673 |    e = 4
;   27  403   15  905  363  489    0 1012    0  581 |    f = 5
;  606  119    1  858 1107    1    4  507    0  934 |    g = 6
;   34  798    2  875  372   82    0 1647    0  591 |    h = 7
;  793   60    1  359 1974    9    0  150    0  717 |    i = 8
;  227   82    0  992 1303    0    1  348    0 1235 |    j = 9
;, :kappa 0.2618694171179577, :f-measure {:0 0.586990351696234, :4 0.335276553391156, :7 0.3176776931237342, :1 0.7767078488372093, :8 0.0, :9 0.22838650023116044, :2 0.007124198527665637, :5 0.20724729815638906, :3 0.23765629278087066, :6 0.001926318324103058}, :percentage-correct 33.7, :correct 14154.0}