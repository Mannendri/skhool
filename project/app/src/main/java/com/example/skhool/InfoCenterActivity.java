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

        ArrayList<InfoItem> info9 = new ArrayList<>();
        String grades9 = "\u2022 Grades are important in ninth grade along with academic rigor. Make sure you seek advice from a guidance counselor " +
                "or teacher to ensure you are choosing challenging courses.\n" +
                "\u2022 Writing is essential to nearly every class in high school and college. If " +
                "you need extra help or tutoring in writing, get it now. Don't worry about receiving a bad essay grade, but make sure you learn from " +
                "your mistakes";
        info9.add(new InfoItem("Grades", grades9,R.drawable.grades));
        String scores9 = "\u2022 Be aware of Regents exams. It is important that you take these exams and perform well on them.\n" +
                "\u2022 Try to be reading all the time!\n" +
                "\u2022 Use the resources available to you at local community organizations and your public library.\n";
        info9.add(new InfoItem("Scores",scores9,R.drawable.book));
        String activities9 = "\u2022Make your summers count. Find a job or program that builds on favorite subjects, extracurriculars, or hobbies";
        info9.add(new InfoItem("Activities",activities9,R.drawable.activity));
        String legwork9 = "\u2022 Start talking to your family about your family budget. How will you pay for college? You can start saving now for " +
                "a laptop or other college essentials.\n" +
                "\u2022 Start looking into requirements for honors or scholarship programs at colleges. These programs can help significantly on the " +
                "financial front.\n" +
                "\u2022 Make sure that your identity (i.e. your name) is consistent on all transcripts, standardized tests, application, etc.";
        info9.add(new InfoItem("Legwork",legwork9,R.drawable.important));

        ArrayList<InfoItem> info10 = new ArrayList<>();
        String grades10 = "\u2022 Make sure you focus on grades. While you might not be required to take the PSAT this year, taking it can help " +
                "you gauge strengths and weaknesses, and work on improving scores.\n" +
                "\u2022 While registering for 10th grade courses, check your options for 11th grade because many courses have prerequisites.\n" +
                "\u2022 Be wary of academic overload. Create a balance schedule. You want to get good grades, but not be stressed out.\n" +
                "\u2022 You should be most focused on study skills and writing. You are still exploring how you learn best.\n";
        info10.add(new InfoItem("Grades",grades10,R.drawable.grades));
        String scores10 = "\u2022 You may receive information about the PSAT. Taking it in 10th grade can help you get comfortable with the test format.\n" +
                "\u2022 You should consider taking an SAT subject test at the end of 10th grade, especially if you are enrolled in an AP or honors course. " +
                "You can take a practice exam online at www.CollegeBoard.com. Some colleges and universities require students to have one or two SAT subject tests" +
                " for admittance";
        info10.add(new InfoItem("Scores",scores10,R.drawable.book));
        String activities10 = "\u2022 Make a resume of activities, academic experiences outside the classroom, hobbies, etc. to help keep track of " +
                "achievements.\n" +
                "\u2022 Plan to do something productive over the summer. Work, volunteer, play sports, or take a course at a college.";
        info10.add(new InfoItem("Activities",activities10,R.drawable.activity));
        String legwork10 = "\u2022 Be sure to explore college websites and resources like www.usnews.com. Jot down notes of what you find appealing " +
                "about several colleges.";
        info10.add(new InfoItem("Legwork",legwork10,R.drawable.important));

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

    }

}