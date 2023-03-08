package qsort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    @DisplayName("Check simple sorting")
    void checkSorting() {
        assertAll(
                () -> assertArrayEquals(new int[]{1, 2, 3, 4}, QuickSort.quickSort(new int[]{4, 2, 3, 1}, 0, 3)),
                () -> assertArrayEquals(new int[]{-100, -3, 4, 10, 900}, QuickSort.quickSort(new int[]{10, 4, -3, -100, 900}, 0, 4))
        );
    }

    @Test
    @DisplayName("Check empty")
    void checkEmpty() {
        assertAll(
                () -> assertArrayEquals(new int[]{}, QuickSort.quickSort(new int[]{}, 0, 0)),
                () -> assertArrayEquals(new int[]{}, QuickSort.quickSort(new int[]{}, 0, 0))
        );
    }

    @Test
    @DisplayName("Check repeat values")
    void checkRepeating() {
        assertAll(
                () -> assertArrayEquals(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 100, 100, 100}, QuickSort.quickSort(new int[]{100, 1, 100, 1, 100, 1, 2, 2, 3, 4, 2, 4, 2, 4, 5}, 0, 14))
        );
    }

    @Test
    @DisplayName("Check null value")
    void checkNull() {
       assertThrows(NullPointerException.class, () -> QuickSort.quickSort(null, 0, 1));
    }

    @Test
    @DisplayName("Check already sorted values")
    void checkSorted() {
        assertAll(
                () -> assertArrayEquals(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 100, 100, 100}, QuickSort.quickSort(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 100, 100, 100}, 0, 14))
        );
    }

    @Test
    @DisplayName("Check reversed values")
    void checkReversed() {
        assertAll(
                () -> assertArrayEquals(new int[]{-2, -1, 0, 10, 20, 35}, QuickSort.quickSort(new int[]{35, 20, 10, 0, -1, -2}, 0, 5))
        );
    }

    @Test
    @DisplayName("Check big array")
    void checkBigArray() {
        assertAll(
                () -> assertArrayEquals(new int[]{5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594,595,596,597,598,599,600,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,644,645,646,647,648,649,650,651,652,653,654,655,656,657,658,659,660,661,662,663,664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682,683,684,685,686,687,688,689,690,691,692,693,694,695,696,697,698,699,700,701,702,703,704,705,706,707,708,709,710,711,712,713,714,715,716,717,718,719,720,721,722,723,724,725,726,727,728,729,730,731,732,733,734,735,736,737,738,739,740,741,742,743,744,745,746,747,748,749,750,751,752,753,754,755,756,757,758,759,760,761,762,763,764,765,766,767,768,769,770,771,772,773,774,775,776,777,778,779,780,781,782,783,784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,872,873,874,875,876,877,878,879,880,881,882,883,884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900},
                        QuickSort.quickSort(new int[]{439,749,5,260,84,332,127,859,63,575,783,483,145,618,31,103,644,117,822,893,169,538,216,336,101,576,860,370,91,112,382,238,296,548,809,786,612,832,454,510,716,54,637,302,292,833,819,347,203,463,636,477,734,275,753,555,535,22,506,812,620,129,608,695,357,864,840,866,215,566,696,313,126,455,214,209,499,229,755,838,467,653,10,569,79,564,527,732,829,16,251,683,808,517,102,472,800,344,237,12,365,66,35,705,664,433,417,768,725,821,685,803,428,848,667,157,690,59,632,111,704,220,318,804,596,351,651,767,176,816,396,660,62,894,468,295,227,550,30,504,540,681,421,511,335,57,884,312,440,130,115,602,389,36,490,842,443,398,512,486,206,424,502,333,745,460,480,524,308,577,330,339,123,272,771,303,601,836,46,751,356,802,34,162,509,245,40,178,72,712,325,678,799,400,740,687,895,724,650,291,407,448,827,386,404,140,508,121,230,71,419,76,877,837,322,108,444,82,516,616,628,828,525,830,826,561,242,788,187,592,797,720,674,131,434,9,706,358,221,761,7,87,271,785,362,597,314,762,889,776,128,69,328,198,68,249,710,305,703,659,48,437,354,865,239,505,383,161,718,226,81,537,849,492,268,94,757,96,95,254,645,259,886,773,662,760,562,452,93,679,125,106,715,350,794,807,714,213,420,299,671,446,193,544,135,795,824,164,185,6,736,770,855,136,155,709,574,403,514,479,345,698,202,673,790,759,224,694,359,114,565,225,609,814,896,591,572,133,665,497,872,554,179,488,113,44,521,882,883,21,409,412,361,641,149,766,798,373,45,375,343,90,682,39,847,369,482,556,845,276,438,196,871,815,713,190,191,693,88,150,456,765,529,666,670,80,560,137,491,107,464,582,257,526,835,286,138,542,545,880,551,523,243,899,588,408,639,735,156,891,294,269,263,246,457,14,503,615,97,643,791,787,58,47,747,60,741,549,887,371,465,266,372,274,300,17,393,870,397,607,654,611,342,248,733,184,658,250,388,552,581,630,366,124,805,233,11,110,610,19,846,750,70,401,109,825,411,708,793,661,77,570,323,158,652,669,856,50,119,603,309,414,558,579,173,553,484,743,656,451,810,473,310,520,599,806,533,223,649,168,831,622,844,701,784,432,418,686,811,436,399,719,258,367,311,881,416,796,289,756,204,348,139,194,818,33,772,240,426,876,270,51,324,748,801,522,857,600,18,727,758,170,635,850,873,590,453,466,205,626,67,385,273,697,183,165,789,852,700,264,684,657,241,862,897,730,166,118,49,290,27,489,141,702,717,817,197,211,458,20,64,235,496,605,688,536,186,470,282,425,879,285,494,775,105,431,152,297,476,711,774,646,853,584,722,655,317,633,442,593,391,61,298,316,326,498,278,387,218,86,617,469,820,571,319,159,380,402,163,392,625,779,543,721,874,199,515,493,839,256,792,723,13,175,532,557,284,875,99,435,368,563,98,823,8,160,277,315,132,501,634,395,594,898,341,583,459,24,867,729,338,247,450,746,539,381,763,340,541,406,151,279,104,307,447,188,244,461,863,252,441,346,462,623,707,394,43,668,699,621,861,143,885,25,232,475,647,287,288,360,120,293,153,177,352,752,181,355,534,195,449,691,567,37,337,42,83,513,675,677,429,53,892,689,518,89,384,134,500,851,834,92,598,478,182,144,900,781,379,487,559,485,777,692,147,481,222,55,208,174,573,606,530,547,663,154,841,585,604,304,854,642,586,619,471,262,613,423,378,739,78,265,207,528,878,116,578,32,75,589,731,614,782,148,281,648,531,427,321,146,231,629,726,364,38,353,15,390,234,261,41,142,580,742,100,217,869,306,376,764,192,52,595,519,405,631,236,212,253,640,868,65,180,167,413,301,738,28,363,778,843,445,587,415,228,546,219,888,200,780,122,73,201,349,568,29,267,85,23,507,728,422,890,374,430,474,680,410,627,189,737,320,858,329,171,813,769,744,624,331,754,334,210,56,377,74,676,280,283,26,172,255,672,638,327,495}, 0, 895))
        );
    }
}