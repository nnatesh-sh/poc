package com.stubhub.gcp.csbff.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.stubhub.gcp.csbff.model.RecentlyViewed;
import com.stubhub.gcp.csbff.model.ResultObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    Firestore db;

    @RequestMapping(method = RequestMethod.GET, path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject createFireBaseInstance() {
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId("native-backend-dev-27567")
                        .build();
        Firestore db = firestoreOptions.getService();
        this.db = db;
        return new ResultObject("Firestore Created");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/rve", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject witeToFireBase(@RequestBody RecentlyViewed recenltyViewed){

        DocumentReference docRef = db.collection("rve").document(recenltyViewed.getUserId());
        Map<String, Object> docData = new HashMap<>();
        docData.put("userId", recenltyViewed.getUserId());
        docData.put("eventId", recenltyViewed.getEventId());
        docData.put("timestamp", recenltyViewed.getTimestamp());
        ApiFuture<WriteResult> result = db.collection("rve").document(recenltyViewed.getUserId()).set(docData);


        return new ResultObject(result.toString());

    }

    @RequestMapping(method= RequestMethod.GET, value="/{userId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultObject readFromFireBase(@PathVariable("userId") String userId) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("rve").document(userId);
        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();
        RecentlyViewed recenltyViewed = null;
        if (document.exists()) {
            recenltyViewed = document.toObject(RecentlyViewed.class);
        }
        return new ResultObject(recenltyViewed.toString());

    }

}
