package com.huy.source

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import android.speech.RecognizerIntent

/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @LastEditor: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */
val IMAGE_REQUEST_CODE = 1004
val VOICE_REQUEST_CODE = 1005

val cameraIntent: Intent
    get() = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

val galleryIntent: Intent
    get() {

        val intent = Intent(Intent.ACTION_PICK)
        val directory = android.os.Environment
                .getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_PICTURES)
        val path = directory.path
        val data = Uri.parse(path)
        intent.setDataAndType(data, "image/*")
        return intent
    }

val voiceRecordIntent: Intent
    get() {

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech")
        return intent
    }

val emailIntent: Intent
    get() {

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_EMAIL)
        return intent
    }

val settingsIntent: Intent
    get() = Intent(Settings.ACTION_SETTINGS)