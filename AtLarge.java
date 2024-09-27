//Morgan's code
//public class AtLarge extends Student implements Shopper{
//    public AtLarge(String firstName, String lastName, int studentId) {
//        super(firstName, lastName, studentId);
//    }
//}

//Anisa's Code applies 0.0 which is 0%

public class AtLarge extends Student {
    private String registeredSemester;


     public AtLarge(String name, int studentId, int creditHours, String degree, String registeredSemester) {
         super();
      this.registeredSemester = registeredSemester;
  }
    public String getRegisteredSemester() {
        return registeredSemester;
    }

    public void setRegisteredSemester(String registeredSemester) {
        this.registeredSemester = registeredSemester;
    }

    // Override getDiscount() method to calculate the discount for AtLarge individuals
    @Override
    public double getDiscount() {
     //   if (person instanceof UnderGradStudent) {
     //       return UnderGrad_Discount;
     //   } else if (person instanceof GradStudent) {
    //        return GRAD_DISCOUNT;
     //   } else if (person instanceof Professor) {
     //       return PROFESSOR_DISCOUNT;
       // } else {
        // Default discount (e.g., for other roles)\
        return 0.0;
        // Assuming a 0% discount for AtLarge individuals
        }
    }



