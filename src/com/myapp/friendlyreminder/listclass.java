package com.myapp.friendlyreminder;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class listclass extends ListActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Use our own list adapter
        setListAdapter(new PhoneListAdapter(this));
    }
           
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {    
       ((PhoneListAdapter)getListAdapter()).toggle(position);
    }
    
    /**
     * A sample ListAdapter that presents content
     * from arrays of phones and text.
     */
    private class PhoneListAdapter extends BaseAdapter {
        public PhoneListAdapter(Context context) {
            mContext = context;
        }

        /**
         * The number of items in the list is determined 
         * by the number of phones in our array.
         */
        public int getCount() {
            return mPhones.length;
        }

        /**
         * Since the data comes from an array, just returning
         * the index is sufficent to get at the data. If we
         * were using a more complex data structure, we
         * would return whatever object represents one 
         * row in the list.
         */
        public Object getItem(int position) {
            return position;
        }

        /**
         * Use the array index as a unique id.
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         * Make a PhoneView to hold each row.
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            PhoneView sv;
            if (convertView == null) {
                sv = new PhoneView
			(mContext, mPhones[position], mDetail[position], mExpanded[position]);
            } else {
                sv = (PhoneView)convertView;
                sv.setName(mPhones[position]);
                sv.setDetail(mDetail[position]);
                sv.setExpanded(mExpanded[position]);
            }
            
            return sv;
        }

        public void toggle(int position) {
            mExpanded[position] = !mExpanded[position];
            notifyDataSetChanged();
        }
        
        /**
         * Remember our context so we can use it when constructing views.
         */
        private Context mContext;
        
        /**
         * Our data for names of phones, part 1.
         */
        private String[] mPhones = 
        {
                "HTC Droid Incredible (Verizon Wireless)",   
                "HTC Evo 4G - black (Sprint) ",
                "Apple iPhone 4 ",       
                "RIM BlackBerry Bold 9700 (T-Mobile) ",
                "Samsung Captivate (AT&T) "
        };
        
        /**
         * Our data for the detail description of each phone, part 2.
         */
        private String[] mDetail = 
        {
                "With its polished design and user interface" +
                "and blazing fast speeds, the HTC Droid Incredible" +
                "takes pole position as Verizon's top smartphone" +
                "and is now the Android device to beat.",               
                
                "The HTC Evo 4G is easily Sprint's best smartphone" +
                "and one of today's top Android devices." +
                "It also shows the promise of 4G, which will grow" +
                "as Sprint's WiMax network expands, but until there's" +
                "broader 4G coverage, it's hard to agree with the" +
                "mandatory premium data add-on fee.",

                "With the iPhone 4, Apple again shows that it is a" +
                "powerful player in the smartphone wars. It won't be" +
                "for everyone, the call quality and reception remain" +
                "sticking points, and AT&T remains a sticking point," +
                "but the handset's striking design, loaded feature set," +
                "and satisfying performance make it the best iPhone yet.",
                
                "The RIM BlackBerry Bold 9700 brings T-Mobile its first" +
                "3G BlackBerry and improves on its predecessor" +
                "with a sleeker design and more power. We only wish" +
                "it had a better browser to complete the package.",

                "The Samsung Captivate is easily AT&T's best Android" +
                "offering to date, delivering great performance, tons" +
                "of features, and an easy-to-use interface."           
        };
        
        /**
         * Our data, part 3.
         */
        private boolean[] mExpanded = 
        {
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false   
        };
    }
    
    /**
     * We will use a PhoneView to display each phone. 
     * It's just a LinearLayout with two text fields.
     */
    private class PhoneView extends LinearLayout {
        public PhoneView(Context context, String name, String detail, boolean expanded) {
            super(context);
            
            this.setOrientation(VERTICAL);
            
            // Here we build the child views in code. They could also have
            // been specified in an XML file.
            
            mPhone = new TextView(context);
            mPhone.setText(name);
            addView(mPhone, 
		new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            
            mDetail = new TextView(context);
            mDetail.setText(detail);
            addView(mDetail, 
		new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            
            mDetail.setVisibility(expanded ? VISIBLE : GONE);
        }
        
        /**
         * Convenience method to set the name of a PhoneView
         */
        public void setName(String name) {
            mPhone.setText(name);
        }
        
        /**
         * Convenience method to set the detail of a PhoneView
         */
        public void setDetail(String words) {
            mDetail.setText(words);
        }
        
        /**
         * Convenience method to expand or hide the detail
         */
        public void setExpanded(boolean expanded) {
            mDetail.setVisibility(expanded ? VISIBLE : GONE);
        }
        
        private TextView mPhone;
        private TextView mDetail;
    }
}
