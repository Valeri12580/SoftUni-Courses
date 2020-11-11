(function run(tickets, criteria) {
    let database = new Array();
    tickets.forEach((e) => {
        let split = e.split("|");
        let ticketsObj = {
            destination: split[0],
            price: Number(split[1]),
            status: split[2],
            toString() {
                return `${this.destination} ${this.price} ${this.status}`;
            }
        };
        database.push(ticketsObj);
    });
    switch (criteria) {
        case "destination":
            database.sort((a, b) => a.destination.localeCompare(b.destionation));
            break;
        case "status":
            database.sort((a, b) => a.status.localeCompare(b.status));
            break;
        case "price":
            database.sort((a, b) => a.price - b.price);
            break;
    }
    database.forEach((e) => {
        console.log(e.toString());
    });
})([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.89|sold',
    'Boston|126.20|departed'
], 'status');
//# sourceMappingURL=tickets.js.map