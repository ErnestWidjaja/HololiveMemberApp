package com.example.mysubmissionapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mysubmissionapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MEMBER = "extra_member"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataMember = if (Build.VERSION.SDK_INT >=33) {
            intent.getParcelableExtra<Member>(EXTRA_MEMBER, Member::class.java)
        } else {
            intent.getParcelableExtra<Member>(EXTRA_MEMBER)
        }

        if (dataMember != null) {
            binding.imgPhoto.setImageResource(dataMember.photo)
            binding.tvName.text = dataMember.name
            binding.tvNameJp.text = dataMember.nameJp
            binding.tvDescription.text = dataMember.description
            binding.tvDebut.text = dataMember.debut
            binding.tvBirthday.text = dataMember.birthday
            binding.tvHeight.text = dataMember.height
            binding.tvUnit.text = dataMember.unit
        }

        binding.actionShare.setOnClickListener {
            val message = "Name : ${dataMember?.name} (${dataMember?.nameJp})\nDescription : ${dataMember?.description}\nDebut Date : ${dataMember?.debut}\nBirthday : ${dataMember?.birthday}\nHeight : ${dataMember?.height}\nUnit : ${dataMember?.unit}"
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(shareIntent)
        }
    }
}