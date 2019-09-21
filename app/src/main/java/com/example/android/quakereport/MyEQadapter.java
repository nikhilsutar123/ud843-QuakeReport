package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyEQadapter extends ArrayAdapter {

    public MyEQadapter(@NonNull Context context, int resource,List<Earthquake> Earthquake) {
        super(context, 0, Earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_activity, parent, false);
        }

        Earthquake eq = (Earthquake) getItem(position);

        TextView mag = itemView.findViewById(R.id.mag);

        DecimalFormat format = new DecimalFormat("0.0");
        String output = format.format(eq.getMag());
        mag.setText(output);

        String ogName = eq.getCity();

        String part1, part2, substitutionCode = "Near the ";

        TextView locOffset = itemView.findViewById(R.id.locOffset);
        TextView city = itemView.findViewById(R.id.city);

        if (ogName.contains("of")) {
            //divide original string in two parts including "of"
            String[] divideName = ogName.split("(?<=of)");
            part1 = divideName[0];
            part2 = divideName[1];

            //display 1st half of the location e.g "24Km NW of"
            locOffset.setText(part1);

            //display 2nd half of the location in e.g "Rumoi, Japan"
            city.setText(part2);
        } else {
            locOffset.setText(substitutionCode);
            city.setText(ogName);
        }

        Date dateObj = new Date(eq.getDate());
        SimpleDateFormat formatter = new SimpleDateFormat("LLL dd, yyyy");
        String readableDate = formatter.format(dateObj);

        TextView date = itemView.findViewById(R.id.date);
        date.setText(readableDate);

        SimpleDateFormat timeformatter = new SimpleDateFormat("h:mm a");
        String readableTime = timeformatter.format(dateObj);

        TextView Time = itemView.findViewById(R.id.Time);
        Time.setText(readableTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(eq.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return itemView;
    }

    private int getMagnitudeColor(double mag) {
        int MagResId;
        int magfloor = (int) Math.floor(mag);
        switch (magfloor) {
            case 0:
            case 1:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;

            case 2:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;

            case 3:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;

            case 7:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;

            default:
                MagResId = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return MagResId;
    }

}
