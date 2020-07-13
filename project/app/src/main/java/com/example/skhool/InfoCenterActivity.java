package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mymulti_screenapp.InfoAdapter;

import java.util.ArrayList;

public class InfoCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_center);

        ListView infoCenterListView = findViewById(R.id.info_center_list_view);
        // Grade 9
        ArrayList<InfoItem> info9 = new ArrayList<>();
        String grades9 = "\u2022 Grades are important in ninth grade along with academic rigor. Make sure you seek advice from a guidance counselor " +
                "or teacher to ensure you are choosing challenging courses\n" +
                "\u2022 Writing is essential to nearly every class in high school and college. If " +
                "you need extra help or tutoring in writing, get it now. Don't worry about receiving a bad essay grade, but make sure you learn from " +
                "your mistakes";
        info9.add(new InfoItem("Grades", grades9,R.drawable.grades));
        String scores9 = "\u2022 Be aware of Regents exams. It is important that you take these exams and perform well on them\n" +
                "\u2022 Try to be reading all the time!\n" +
                "\u2022 Use the resources available to you at local community organizations and your public library\n";
        info9.add(new InfoItem("Scores",scores9,R.drawable.book));
        String activities9 = "\u2022Make your summers count. Find a job or program that builds on favorite subjects, extracurriculars, or hobbies";
        info9.add(new InfoItem("Activities",activities9,R.drawable.activity));
        String legwork9 = "\u2022 Start talking to your family about your family budget. How will you pay for college? You can start saving now for " +
                "a laptop or other college essentials\n" +
                "\u2022 Start looking into requirements for honors or scholarship programs at colleges. These programs can help significantly on the " +
                "financial front\n" +
                "\u2022 Make sure that your identity (i.e. your name) is consistent on all transcripts, standardized tests, application, etc.";
        info9.add(new InfoItem("Legwork",legwork9,R.drawable.important));
        // Grade 10
        ArrayList<InfoItem> info10 = new ArrayList<>();
        String grades10 = "\u2022 Make sure you focus on grades. While you might not be required to take the PSAT this year, taking it can help " +
                "you gauge strengths and weaknesses, and work on improving scores\n" +
                "\u2022 While registering for 10th grade courses, check your options for 11th grade because many courses have prerequisites\n" +
                "\u2022 Be wary of academic overload. Create a balance schedule. You want to get good grades, but not be stressed out\n" +
                "\u2022 You should be most focused on study skills and writing. You are still exploring how you learn best\n";
        info10.add(new InfoItem("Grades",grades10,R.drawable.grades));
        String scores10 = "\u2022 You may receive information about the PSAT. Taking it in 10th grade can help you get comfortable with the test format\n" +
                "\u2022 You should consider taking an SAT subject test at the end of 10th grade, especially if you are enrolled in an AP or honors course. " +
                "You can take a practice exam online at www.CollegeBoard.com. Some colleges and universities require students to have one or two SAT subject tests" +
                " for admittance";
        info10.add(new InfoItem("Scores",scores10,R.drawable.book));
        String activities10 = "\u2022 Make a resume of activities, academic experiences outside the classroom, hobbies, etc. to help keep track of " +
                "achievements\n" +
                "\u2022 Plan to do something productive over the summer. Work, volunteer, play sports, or take a course at a college.";
        info10.add(new InfoItem("Activities",activities10,R.drawable.activity));
        String legwork10 = "\u2022 Be sure to explore college websites and resources like www.usnews.com. Jot down notes of what you find appealing " +
                "about several colleges.";
        info10.add(new InfoItem("Legwork",legwork10,R.drawable.important));
        // Grade 11
        ArrayList<InfoItem> info11 = new ArrayList<>();
        String grades11 = "\u2022 Junior year grades are the most vital ones on college applications. Make sure you are on track with assignments" +
                " and seek extra help in any subject areas if needed \n" +
                "\u2022 Remember to speak up in class and make good impressions on teachers. You will eventually need to ask at least two " +
                "teachers to write recommendation letters.";
        info11.add(new InfoItem("Grades",grades11,R.drawable.grades));
        String scores11 = "\u2022 You may be taking the PSAT in the fall. If scores from 10th grade were strong and there's a shot at a national" +
                " merit scholarship, it's worth spending time preparing for the test \n" +
                "\u2022 Start talking with your parents about financial plans, research scholarships and other resources to assist in paying for college \n" +
                "\u2022 Speak with a guidance counselor regarding testing plans. The SAT and ACT are given in the winter, and can be retaken in the spring \n" +
                "\u2022 SAT subject tests are given in the spring, too, and should be taken in subjects that were covered in junior year";
        info11.add(new InfoItem("Scores",scores11,R.drawable.book));
        String activities11 = "\u2022 All of the time you've spent at after-school practices or meetings will be time well spent for you. Being" +
                " a leader shows colleges that you work hard and are a team player";
        info11.add(new InfoItem("Activities", activities11,R.drawable.activity));
        String legwork11 = "\u2022 In the fall, a college counselor should be reviewing the list of potential colleges with you. You should begin" +
                " building a realistic college list with a balance of choices\n" +
                "\u2022 Make time for college visits over spring break or the summer and attend college fairs. Try to correspond with " +
                "colleges that you are interested in - it shows that you are serious about the college\n" +
                "\u2022 Procrastination doesn't make for a good college essay. Aim to have first drafts done by September in time to show" +
                " an English teacher or counselor come fall";
        info11.add(new InfoItem("Legwork",legwork11,R.drawable.important));
        // Grade 12
        ArrayList<InfoItem> info12 = new ArrayList<>();
        String grades12 = "\u2022 Make sure you are completing your high school's graduation requirements and meeting course requirements of the" +
                " colleges on your list (these are often outlined on their websites). Watch out for foreign language, science and math requirements\n" +
                "\u2022 College admission is contingent upon consistent academic performance on the final transcript. Make sure you don't slack off on " +
                "performance - grades still count";
        info12.add(new InfoItem("Grades",grades12,R.drawable.grades));
        String scores12 = "\u2022 This is your final change to retake the SAT, ACT, or subject tests, if needed. October test dates are often the " +
                "last before early action, early decision or December regular admission deadlines. For January deadlines, November and December test " +
                "are still options. Visit www.nacacnet.org to learn more about different admission categories";
        info12.add(new InfoItem("Scores",scores12,R.drawable.book));
        String legwork12 = "\u2022 September: Find out your school's procedure for obtaining teacher recommendations and requesting grade transcripts" +
                " to be sent to colleges\n" +
                "\u2022 October, November, December: Application time! Be sure you work on your applications carefully and edit essays one more time\n" +
                "\u2022 By December (or earlier): Finish all your applications; check that the colleges have received records and recommendations from " +
                "your high school. Officially send SAT or ACT scores\n" +
                "\u2022 February: Many colleges require FAFSA and CSS (financial aid) forms to be turned in by February. Again, earlier is better\n" +
                "\u2022 March, April: Decisions arrive. Stay calm. Breathe\n" +
                "\u2022 April: Explore and/or revisit colleges to which you were accepted\n" +
                "\u2022 May 1: Your college decision must be made officially. Finally!";
        info12.add(new InfoItem("Legwork",legwork12,R.drawable.important));


        Intent data = getIntent();
        String grade = data.getStringExtra("grade");
        if (grade.equals("9")){
            com.example.mymulti_screenapp.InfoAdapter infoAdapter = new InfoAdapter(this, info9);
            infoCenterListView.setAdapter(infoAdapter);
        }
        else if (grade.equals("10")){
            com.example.mymulti_screenapp.InfoAdapter infoAdapter = new InfoAdapter(this, info10);
            infoCenterListView.setAdapter(infoAdapter);
        }
        else if (grade.equals("11")){
            com.example.mymulti_screenapp.InfoAdapter infoAdapter = new InfoAdapter(this, info11);
            infoCenterListView.setAdapter(infoAdapter);
        }
        else if (grade.equals("12")){
            com.example.mymulti_screenapp.InfoAdapter infoAdapter = new InfoAdapter(this, info12);
            infoCenterListView.setAdapter(infoAdapter);
        }

    }

}