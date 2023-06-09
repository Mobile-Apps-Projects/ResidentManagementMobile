import requests
import argparse

parser = argparse.ArgumentParser(description="Create a new document in Firestore.")
parser.add_argument("option", choices=["create", "delete"], help="Create or delete a document.")

args = parser.parse_args()

invoice_url = "https://firestore.googleapis.com/v1/projects/residentmanagement-dc0b3/databases/(default)/documents/apartamentos/spqO2yAWlx9w7uPuFkMZ/facturas"
message_url = "https://firestore.googleapis.com/v1/projects/residentmanagement-dc0b3/databases/(default)/documents/apartamentos/mRzTe1DIdpauuoK3xfTnXX9tBPy1/mensajes"

if args.option == "create":
    print("Creating a new document...")

    invoice = {
      "fields": {
        "concepto": {
          "stringValue": "Example Concept"
        },
        "date": {
          "timestampValue": "2023-06-11T00:00:00Z"
        },
        "valor": {
          "doubleValue": 150000.99
        }
      }
    }

    invoice_response = requests.post(invoice_url, json=invoice)
    print(invoice_response.json())

    invoice_id = invoice_response.json().get("name").split("/")[-1]
    with open("invoice_id.txt", "w") as f:
        f.write(invoice_id)

    invoice["fields"]["id"] = {
      "stringValue": invoice_id
    }

    update_url = f"{invoice_url}/{invoice_id}"

    update_response = requests.patch(update_url, json=invoice)

    if update_response.ok:
      print("Invoice created and updated successfully!")
    else:
      print("Failed to create or update the invoice.")


    message = {
        "fields": {
            "contenido": {
                "stringValue": "El día 10 de marzo será suspendido el servicio de electricidad..."
            },
            "date": {
                "timestampValue": "2023-06-09T19:20:00Z"
            },
            "titulo": {
                "stringValue": "Corte electricidad"
            },
            "src": {
                "stringValue": "Administración"
            }
        }
    }

    message_response = requests.post(message_url, json=message)

    message_id = message_response.json().get("name").split("/")[-1]

    message["fields"]["id"] = {
        "stringValue": message_id
    }

    update_url = f"{message_url}/{message_id}"

    update_response = requests.patch(update_url, json=message)

    if update_response.ok:
        print("Message created and updated successfully!")
    else:
        print("Failed to create or update the message.")

elif args.option == "delete":
    print("Deleting an invoice...")

    with open("invoice_id.txt", "r") as f:
        invoice_id = f.read()

    delete_url = f"{invoice_url}/{invoice_id}"

    delete_response = requests.delete(delete_url)

    if delete_response.ok:
        print("Document deleted successfully!")
        with open("invoice_id.txt", "w") as f:
            f.truncate(0)
    else:
        print("Failed to delete the document.")


    payed_message = {
        "fields": {
            "contenido": {
                "stringValue": "Su pago para la factura de junio fue recibido exitosamente."
            },
            "date": {
                "timestampValue": "2023-06-20T19:40:00Z"
            },
            "titulo": {
                "stringValue": "Pago recibido"
            },
            "src": {
                "stringValue": "Administración"
            }
        }
    }

    message_response = requests.post(message_url, json=payed_message)

    message_id = message_response.json().get("name").split("/")[-1]

    payed_message["fields"]["id"] = {
        "stringValue": message_id
    }

    update_url = f"{message_url}/{message_id}"

    update_response = requests.patch(update_url, json=payed_message)

    if update_response.ok:
        print("Message created and updated successfully!")
    else:
        print("Failed to create or update the message.")
