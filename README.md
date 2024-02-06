# Trip Checklist App
Generates checklists for your trips.

## Application startup
By default the application is listening on port 8080.

There are 2 ways to start the application:
- With Docker
- With Maven

### Application startup with Docker
Prerequisites:
- Docker

First - build the Docker image:
```console
docker build -t packify .
```

Next - start the application:
```console
docker compose up -d
```

Lastly - you can stop the application with:
```console
docker compose down
```


### Application startup with Maven
Prerequisites:
- JDK 17

First - build the project:
```console
./mvnw clean package
```
Next - start the application:
```console
./mvnw spring-boot:run
```

## API
### GET /trip/checklist
Returns a checklist with recommended items to take on a trip based on the given parameters.

Query params:

| Name | Type | Mandatory | Default Value | Description |
|------|------|-----------|---------------|-------------|
| days| Integer | Yes | - | Trip duration in days |
| start | Date | No | Current date |  Trip start date, format: YYYY-MM-DD, e.g. 2024-07-24 |
| location | String | No | - | Trip location, doesn't do anything at the moment |
| terrain | Enum | No | - | Trip terrain, allowed values are: PAVED_ROADS, FOREST, MOUNTAIN |
| profile.age | Integer | No | - | Your age |
| profile.weight | Float | No | - | Your weight |
| profile.height | Float | No | - | Your height |
| profile.gender | Enum | No | - | Your gender, allowed values are: MALE, FEMALE |

#### Request example
GET http://localhost:8080/trip/checklist?days=3&start=2024-07-24&location=Kaunas&terrain=PAVED_ROADS&profile.age=27&profile.weight=80&profile.height=185&profile.gender=MALE
#### Response example
200 OK
```json
{
  "food": {
    "caloriesPerDay": 3268,
    "totalCalories": 9804
  },
  "items": [
    {
      "type": "Backpack",
      "quantity": 1,
      "options": [
        {
          "name": "Osprey Exos 38 Litre Ultralight Overnight Backpack",
          "category": "BAGS",
          "attributes": [
            {
              "key": "CAPACITY",
              "value": "38",
              "displayValue": "38 Litres"
            },
            {
              "key": "BRAND",
              "value": "Osprey",
              "displayValue": "Osprey"
            },
            {
              "key": "WEIGHT",
              "value": "1113",
              "displayValue": "1.13 kg."
            },
            {
              "key": "COLOR",
              "value": "GREEN",
              "displayValue": "Green"
            }
          ]
        }
      ]
    },
    {
      "type": "Boots",
      "quantity": 1,
      "options": null
    },
    {
      "type": "Pants",
      "quantity": 1,
      "options": null
    },
    {
      "type": "Shirt",
      "quantity": 1,
      "options": null
    },
    {
      "type": "Socks",
      "quantity": 3,
      "options": null
    },
    {
      "type": "Sunglasses",
      "quantity": 1,
      "options": null
    },
    {
      "type": "Tent",
      "quantity": 1,
      "options": null
    }
  ]
}
```