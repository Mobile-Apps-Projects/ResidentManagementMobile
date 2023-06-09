import requests

# Define the Firestore API endpoint URL
url = "https://firestore.googleapis.com/v1/projects/residentmanagement-dc0b3/databases/(default)/documents/apartamentos/spqO2yAWlx9w7uPuFkMZ/facturas"

# Define the request payload
payload = {
  "fields": {
    "concepto": {
      "stringValue": "Example Concept"
    },
    "date": {
      "timestampValue": "2023-05-01T00:00:00Z"
    },
    "valor": {
      "doubleValue": 1500000.99
    }
  }
}

# Send the POST request to create the document
response = requests.post(url, json=payload)

# Extract the generated ID from the response
document_id = response.json().get("name").split("/")[-1]

# Update the "id" field with the generated ID
payload["fields"]["id"] = {
  "stringValue": document_id
}

# Define the URL for updating the document
update_url = f"{url}/{document_id}"

# Send the PATCH request to update the document with the generated ID
update_response = requests.patch(update_url, json=payload)
print(update_response.json())
# Check the response status code
if update_response.ok:
  print("Document created and updated successfully!")
else:
  print("Failed to create or update the document.")

# Send notification about new invoice
notify_url = "https://fcm.googleapis.com/fcm/send"

headers = {
    "Authorization": "key=AAAAHZhxqnQ:APA91bGV9W7AmAD6AyIVTvr8TR4LTBRUuNu0dG6TjT0uttd29XPfbiTmMyTU1CPs830yCJ4wFDBgTHX5Gni0oXqqgT2-ZCKfQoOshOa7K3tnPCgzW_Hr-SXZqykC1U_2UmVvbaBWZnOe",
    "Content-Type": "application/json"
}
data = {
    "to": "/topics/all",
    "data": {
        "titulo": "Nueva Factura",
        "contenido": "Tiene una factura pendiente por pagar"
    }
}

notification_response = requests.post(notify_url, headers=headers, json=data)

if notification_response.status_code == 200:
    print("Notification sent successfully!")
else:
    print("Failed to send notification. Error:", response.text)