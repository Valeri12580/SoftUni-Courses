

function solve(array, sortingCriteria) {
    class Tickets {
       
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.setStatus=status
        }


        set setStatus(status) {
            this.status = status
        }
    }

    return array.reduce((acc, current) => {
        let [destination, price, status] = current.split("|")
        let ticket = new Tickets(destination, Number(price), status)
        acc.push(ticket)
        return acc
    }, []).sort(sorting)



    function sorting(a, b) {
        if (sortingCriteria === "price") {
            return a[sortingCriteria] - b[sortingCriteria]
        }
        return a[sortingCriteria].localeCompare(b[sortingCriteria])
    }




}
console.log(
    solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
        'destination'));
