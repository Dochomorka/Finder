package org.cursor.tech.finder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.cursor.tech.finder.data.FinderApp

class ApplicationAdapter internal constructor(context: Context): RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder>() {
    var apps = mutableListOf<FinderApp>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.installed_application_list_item,parent,false)
        return ApplicationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApplicationViewHolder, position: Int) {
        val finderApp = apps[position]
        holder.applicationIcon.setImageDrawable(finderApp.drawable)
        holder.applicationLabel.text = finderApp.label
    }

    override fun getItemCount(): Int {
        return  apps.size
    }
    fun setApplications(apps: MutableList<FinderApp>){
        this.apps.clear()
        this.apps = apps
        notifyDataSetChanged()
    }
    inner class ApplicationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val applicationIcon: ImageView
        val applicationLabel: TextView

        init {
            applicationIcon = itemView.findViewById(R.id.applicationIconImageView)
            applicationLabel = itemView.findViewById(R.id.applicationLabelTextView)
        }

    }
}