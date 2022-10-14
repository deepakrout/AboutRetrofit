package net.routio.aboutretrofit1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AboutContentAdapter extends BaseAdapter {

    Context _context;
    AboutContent[] _aboutContent;
    LayoutInflater inflater;

    public AboutContentAdapter(Context ctx, AboutContent[] aboutContent) {
        _context = ctx;
        _aboutContent = aboutContent;
        inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return _aboutContent.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int p, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_aboutcontent, null);
        TextView titleView = (TextView) convertView.findViewById(R.id.title);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.description);
        titleView.setText(_aboutContent[p].getTitle());
        descriptionView.setText(_aboutContent[p].getDescription());
        return  convertView;
    }
}
