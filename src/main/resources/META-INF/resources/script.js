document.addEventListener('DOMContentLoaded', function() {
    const timeElement = document.querySelector('.updatedAt');
    const utcTimeString = timeElement.textContent;

    if (utcTimeString && utcTimeString !== 'unknown') {
        const timeAgo = calculateTimeAgo(utcTimeString);
        timeElement.textContent = timeAgo;

        const localTime = convertToLocalTime(utcTimeString);
        const timeDescElement = document.querySelector('.updatedAtDesc');
        timeDescElement.textContent = localTime;
    }

    function calculateTimeAgo(utcTimeString) {
        const eventTime = moment.utc(utcTimeString);
        return eventTime.fromNow();
    }

    function convertToLocalTime(utcTimeString) {
        const utcDate = new Date(utcTimeString);
        return utcDate.toLocaleString('en-US', {
            year: 'numeric',
            month: 'short',
            day: 'numeric',
            hour: '2-digit',
            minute: '2-digit',
            second: '2-digit'
        });
    }
});
