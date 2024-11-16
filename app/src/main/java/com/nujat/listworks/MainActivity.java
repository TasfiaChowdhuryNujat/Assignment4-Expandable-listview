package com.nujat.listworks;



import android.os.Bundle;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        expandableListView.setAdapter(listAdapter);

        // Ensure only one group is expanded at a time
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int groupCount = listAdapter.getGroupCount();
                for (int i = 0; i < groupCount; i++) {
                    if (i != groupPosition) {
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        // Adding header data
        listDataHeader.add("Programming Languages");
        listDataHeader.add("Markup Languages");
        listDataHeader.add("Style Languages");
        listDataHeader.add("Database Languages");
        listDataHeader.add("Scripting Languages");
        listDataHeader.add("Query Languages");

        // Adding child data for "Programming Languages"
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("Swift");

        // Adding child data for "Markup Languages"
        List<String> markupLanguages = new ArrayList<>();
        markupLanguages.add("HTML");
        markupLanguages.add("XML");
        markupLanguages.add("Markdown");
        markupLanguages.add("LaTeX");

        // Adding child data for "Style Languages"
        List<String> styleLanguages = new ArrayList<>();
        styleLanguages.add("CSS");
        styleLanguages.add("SCSS");
        styleLanguages.add("Sass");
        styleLanguages.add("Less");

        // Adding child data for "Database Languages"
        List<String> databaseLanguages = new ArrayList<>();
        databaseLanguages.add("SQL");
        databaseLanguages.add("PL/SQL");
        databaseLanguages.add("T-SQL");
        databaseLanguages.add("PostgreSQL");

        // Adding child data for "Scripting Languages"
        List<String> scriptingLanguages = new ArrayList<>();
        scriptingLanguages.add("JavaScript");
        scriptingLanguages.add("PHP");
        scriptingLanguages.add("Perl");
        scriptingLanguages.add("Ruby");

        // Adding child data for "Query Languages"
        List<String> queryLanguages = new ArrayList<>();
        queryLanguages.add("SPARQL");
        queryLanguages.add("XQuery");
        queryLanguages.add("GraphQL");
        queryLanguages.add("Cypher");

        // Mapping headers to children
        listHash.put(listDataHeader.get(0), programmingLanguages);
        listHash.put(listDataHeader.get(1), markupLanguages);
        listHash.put(listDataHeader.get(2), styleLanguages);
        listHash.put(listDataHeader.get(3), databaseLanguages);
        listHash.put(listDataHeader.get(4), scriptingLanguages);
        listHash.put(listDataHeader.get(5), queryLanguages);
    }
}