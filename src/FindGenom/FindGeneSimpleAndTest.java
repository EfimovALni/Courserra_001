package FindGenom;

public class FindGeneSimpleAndTest {

    public static String findGeneSimple(String dna) {
//        start codon is "ATG"
//        stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");

        if (startIndex == -1) { // no 'ATG'
            return "no 'ATG'";
        }

        int stopIndex = dna.indexOf("TAA", startIndex + 3);

        if (stopIndex == -1) { // no 'TAA'
            return "no TAA";
        }
        result = dna.substring(startIndex, stopIndex + 3);

        if ((result.length() % 3) == 0) {
            System.out.println("_____________ is ok");
        } else {
            System.out.println("_____________ is NOT ok");
        }

        return result;
    }

    public static void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is "+ dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "ATGTAA";
        System.out.println("DNA is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "TAATAA";
        System.out.println("DNA is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "CGATGGTTTG";
        System.out.println("DNA is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

//        Fixed the algorithm
        dna = "AGATGCGATACGCTTAATC";
        dna = "AGATGCGATACGCTAATC"; // wrong genome
    }


    public static void main(String[] args) {
        testFindGeneSimple();
        String a = "a";
        String b = "brana";
        int pos = b.indexOf(a);

        System.out.println(b.indexOf(a));

    }
}
