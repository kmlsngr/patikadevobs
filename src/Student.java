public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkVerbalExamNote(int verbalMat, int verbalFizik, int verbalKimya) {

        if (verbalMat >= 0 &&   verbalMat <= 100) {
            this.mat.verbalNote = verbalMat;
        }

        if (verbalFizik >= 0 && verbalFizik <= 100) {
            this.fizik.verbalNote = verbalFizik;
        }

        if (verbalKimya >= 0 && verbalKimya <= 100) {
            this.kimya.verbalNote = verbalKimya;
        }

    }
    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }}
        public void addBulkExamNoteWeight(int weightMat, int weightFizik, int weightKimya){

            if (weightMat >= 0 && weightMat <= 100) {
                this.mat.noteWeight = weightMat;
            }

            if (weightFizik >= 0 && weightFizik <= 100) {
                this.fizik.noteWeight = weightFizik;
            }

            if (weightKimya >= 0 && weightKimya <= 100) {
                this.kimya.noteWeight = weightKimya;
            }
        }
    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((((this.mat.note*(this.mat.noteWeight/100))+this.mat.verbalNote*((100-this.fizik.noteWeight)/100))+((this.fizik.note*(this.fizik.noteWeight/100))+this.fizik.verbalNote*((100-this.fizik.noteWeight)/100))+((this.kimya.note*(this.kimya.noteWeight/100))+this.kimya.verbalNote*((100-this.kimya.noteWeight)/100)))/3);
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}