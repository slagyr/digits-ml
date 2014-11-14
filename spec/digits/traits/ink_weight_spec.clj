(ns digits.traits.ink-weight-spec
  (:require [speclj.core :refer :all]
            [digits.traits.ink-weight :refer :all]))

(describe "Ink Weight"

    (it "measures ink weight of an image"
      (should= 0 (weight-ink []))
      (should= 0 (weight-ink [0 0 0 0 0 0 0 0 0]))
      (should= 8 (weight-ink [1 1 1 1 1 1 1 1]))
      (should= (apply + (range 256)) (weight-ink (into-array Short/TYPE (range 256)))))

    ;(it "cross validates ink-weight"
    ;  (let [strategy (classify/create-classification-strategy {:ink-weight ink-weight}
    ;                                                          [:lazy :ibk {:num-neighbors 3}]
    ;                                                          (data/training-data))
    ;        validation (classify/cross-validate strategy 3)]
    ;    (println validation)
    ;    (should (> (:percentage-correct validation) 50))))

    )


; Summary: This is not good at all.a

;{:average-cost 0.0, :incorrect 34067.0, :roc-area {:0 0.654387611508505, :4 0.5176700125695713, :7 0.5345845643559475, :1 0.8213725668944686, :8 0.5497637828265758, :9 0.5250124977380174, :2 0.5332865011124894, :5 0.49452434934690276, :3 0.5149073047375833, :6 0.5004487445421639}, :false-positive-rate {:0 0.1869652477025457, :4 0.08708605779371441, :7 0.04989494401446847, :1 0.1182870618501447, :8 0.03959195508342779, :9 0.04212948270390352, :2 0.14623377310102317, :5 0.05706059416306766, :3 0.12093282690111291, :6 0.05374640150014526}, :unclassified 0.0, :sf-entropy-gain -293852.5767800396, :kb-mean-information 0.6541140947227766, :kb-information 27472.791978356618, :percentage-incorrect 81.11190476190477, :root-relative-squared-error 109.27263116021639, :precision {:0 0.1943559399180701, :4 0.12060702875399361, :7 0.15342960288808663, :1 0.41652346331791146, :8 0.13578826237054084, :9 0.12664473684210525, :2 0.1205279058673875, :5 0.08900961136648558, :3 0.11540703322323684, :6 0.10901926444833625}, :error-rate 0.8111190476190476, :percentage-unclassified 0.0, :recall {:0 0.4133591481122943, :4 0.1112475442043222, :7 0.07725516927970916, :1 0.6727156276686592, :8 0.05808515874969235, :9 0.05515759312320917, :2 0.18146995451280823, :5 0.05612648221343874, :3 0.13652034015168926, :6 0.06018854242204496}, :correlation-coefficient {:nan Can't compute correlation coefficient: class is nominal!}, :mean-absolute-error 0.16719609042435413, :summary
;Correctly Classified Instances        7933               18.8881 %
;Incorrectly Classified Instances     34067               81.1119 %
;Kappa statistic                          0.0975
;Mean absolute error                      0.1672
;Root mean squared error                  0.3278
;Relative absolute error                 92.9163 %
;Root relative squared error            109.2726 %
;Coverage of cases (0.95 level)          41.6262 %
;Mean rel. region size (0.95 level)      29.9595 %
;Total Number of Instances            42000
;, :kb-relative-information 827524.1715577436, :false-negative-rate {:0 0.5866408518877058, :4 0.8887524557956779, :7 0.9227448307202909, :1 0.3272843723313407, :8 0.9419148412503077, :9 0.9448424068767909, :2 0.8185300454871918, :5 0.9438735177865613, :3 0.8634796598483108, :6 0.939811457577955}, :relative-absolute-error 92.9163145403612, :root-mean-squared-error 0.32776565991904266, :sf-mean-entropy-gain -6.996489923334276, :evaluation-object #<Evaluation weka.classifiers.Evaluation@2a39f240>, :confusion-matrix === Confusion Matrix ===
;
;    a    b    c    d    e    f    g    h    i    j   <-- classified as
; 1708  118  721  517  212  191  224   75  268   98 |    a = 0
;  134 3151  179  190  316  173   84  259   32  166 |    b = 1
; 1161  283  758  577  339  264  263  175  200  157 |    c = 2
; 1073  368  760  594  398  267  273  217  208  193 |    d = 3
;  642  721  616  514  453  258  228  286  136  218 |    e = 4
;  721  605  609  502  374  213  204  220  158  189 |    f = 5
; 1004  426  688  556  391  226  249  186  220  191 |    g = 6
;  546  975  598  551  489  290  267  340  128  217 |    h = 7
; 1153  236  737  565  321  236  249  166  236  164 |    i = 8
;  646  682  623  581  463  275  243  292  152  231 |    j = 9
;, :kappa 0.0974558820228985, :f-measure {:0 0.2643962848297214, :4 0.11573837506387327, :7 0.10276560374792201, :1 0.5144909788554167, :8 0.08136528184795723, :9 0.07684630738522955, :2 0.1448499904452513, :5 0.06884292178409825, :3 0.12507896399241944, :6 0.07755801277059649}, :percentage-correct 18.88809523809524, :correct 7933.0}