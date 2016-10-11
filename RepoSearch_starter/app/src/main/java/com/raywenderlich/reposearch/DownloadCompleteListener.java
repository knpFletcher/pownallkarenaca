package com.raywenderlich.reposearch;

import java.util.ArrayList;

public interface DownloadCompleteListener {
    void downloadComplete(ArrayList<Repository> repositories);
}
