document.addEventListener("DOMContentLoaded", function () {
    const datePaidInput = document.getElementById("datePaid");
    const totalFeesInput = document.getElementById("totalFees");
    const feePaidInput = document.getElementById("feePaid");
    const prevRemainingFeesInput = document.getElementById("prevRemainingFees");
    const remainingFeesInput = document.getElementById("remainingFees");

    // Set today's date
    if (datePaidInput) {
        const today = new Date().toISOString().split("T")[0];
        datePaidInput.value = today;
        datePaidInput.setAttribute("min", today); // Optional: Prevent past dates
    }

    // Auto-fill previous remaining fees from last row of the table
    const remainingCells = document.querySelectorAll(".remaining-fees");
    if (remainingCells.length > 0 && prevRemainingFeesInput) {
        const lastRemaining = remainingCells[remainingCells.length - 1].textContent.trim();
        prevRemainingFeesInput.value = lastRemaining;
        if (remainingFeesInput) remainingFeesInput.value = lastRemaining;
    }

    // Auto-fill Total Fees from the last row in the table
    const table = document.getElementById("feeTable");
    if (table && totalFeesInput) {
        const lastRow = table.querySelector("tbody tr:last-child");
        if (lastRow) {
            const totalCell = lastRow.cells[3]; // 4th column: Total Fees
            if (totalCell) {
                const totalValue = parseFloat(totalCell.textContent.trim());
                if (!isNaN(totalValue)) {
                    totalFeesInput.value = totalValue.toFixed(2);
                }
            }
        }
    }

    // Fee Calculation
    function calculateRemaining() {
        const total = parseFloat(totalFeesInput?.value) || 0;
        const paid = parseFloat(feePaidInput?.value) || 0;
        const prevRemaining = parseFloat(prevRemainingFeesInput?.value) || null;

        let remaining = prevRemaining !== null ? (prevRemaining - paid) : (total - paid);
        if (remainingFeesInput) {
            remainingFeesInput.value = Math.max(0, remaining).toFixed(2);
        }
    }

    if (feePaidInput) {
        feePaidInput.addEventListener("input", calculateRemaining);
    }
    if (totalFeesInput) {
        totalFeesInput.addEventListener("input", calculateRemaining);
    }
});
