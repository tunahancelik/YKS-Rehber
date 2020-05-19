package com.anemon.ykssayac;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private static String gun;




    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, 2020);
        c.set(Calendar.MONTH, 6); // 11 aralık
        c.set(Calendar.DAY_OF_MONTH, 25);
        c.set(Calendar.HOUR_OF_DAY, 10);

        Date tyt = c.getTime();
        Date bugun = new Date();
        long Tsaat = tyt.getTime() - bugun.getTime();
        Tsaat = Tsaat / (1000L*60L*60L);
        int gune = (int)  Tsaat/24;
        int saat = (int) Tsaat/24;
        gun=String.valueOf(gune);


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.witget2, gun);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }












    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

