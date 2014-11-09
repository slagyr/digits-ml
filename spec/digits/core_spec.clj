(ns digits.core-spec
  (:require [digits.classify :as classify]
            [digits.core :refer :all]
            [digits.data :as data]
            [speclj.core :refer :all]))

(describe "digits.core"

  (context "Active Pixels"

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

  (context "Ink Weight"

    (it "measures ink weight of an image"
      (should= 0 (ink-weight []))
      (should= 0 (ink-weight [0 0 0 0 0 0 0 0 0]))
      (should= 8 (ink-weight [1 1 1 1 1 1 1 1]))
      (should= (apply + (range 256)) (ink-weight (into-array Short/TYPE (range 256)))))

    (it "cross validates ink-weight"
      (let [strategy (classify/create-classification-strategy {:ink-weight ink-weight}
                                                              [:lazy :ibk {:num-neighbors 3}]
                                                              (data/training-data))
            validation (classify/cross-validate strategy 3)]
        (println validation)
        (should (> (:percentage-correct validation) 50))
        )
    )

  (context "Transitions"

    (it "counts transitions form white to black"
      (should= 0 (count-transitions [0 0 0 0 0 0 0]))
      (should= 1 (count-transitions [0 0 0 255 0 0 0]))
      (should= 1 (count-transitions [0 0 0 1 0 0 0]))
      (should= 2 (count-transitions [0 0 0 1 0 1 0]))
      (should= 1 (count-transitions [0 0 0 1 1 1 0])))

    ;(it "cross validates transitions"
    ;      (let [strategy (classify/create-classification-strategy {:transition-count count-transitions}
    ;                                                              [:lazy :ibk]
    ;                                                              (data/training-data))
    ;            validation (classify/cross-validate strategy 3)]
    ;        (println validation)
    ;        (should (> (:percentage-correct validation) 50))
    ;        ))

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
    )

  )

(run-specs)