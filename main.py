from fastapi import FastAPI
from pydantic import BaseModel
from typing import List

app = FastAPI(title="Accessibility Assistant Backend")

# ---------------- INPUT MODEL ----------------
class AccessibilityRequest(BaseModel):
    vision_type: str          # normal / positive / negative
    eye_strain: str           # low / medium / high
    usage: List[str]          # study, reading, night, gaming
    features: List[str]       # text_size, dark_mode, image_clarity


# ---------------- OUTPUT MODEL ----------------
class Recommendation(BaseModel):
    title: str
    description: str
    reason: str


# ---------------- API ENDPOINT ----------------
@app.post("/analyze")
def analyze_accessibility(req: AccessibilityRequest):
    results = []

    # ---------- EYE STRAIN ----------
    if req.eye_strain == "high":
        results.append({
            "title": "Enable Dark Mode",
            "description": "Use dark theme to reduce eye strain",
            "reason": "High eye strain detected"
        })

        results.append({
            "title": "Reduce Screen Brightness",
            "description": "Lower brightness to comfortable levels",
            "reason": "Prevents eye fatigue"
        })

    elif req.eye_strain == "medium":
        results.append({
            "title": "Adjust Brightness",
            "description": "Avoid very high brightness levels",
            "reason": "Moderate eye strain detected"
        })

    # ---------- VISION TYPE ----------
    if req.vision_type == "negative":
        results.append({
            "title": "Increase Text Size",
            "description": "Recommended size: 18–20sp",
            "reason": "Low vision detected"
        })

    elif req.vision_type == "positive":
        results.append({
            "title": "Standard Text Size",
            "description": "Default text size is suitable",
            "reason": "Good vision detected"
        })

    # ---------- USAGE ----------
    if "study" in req.usage:
        results.append({
            "title": "Focus Mode",
            "description": "Disable notifications while studying",
            "reason": "Study usage selected"
        })

    if "night" in req.usage:
        results.append({
            "title": "Night Light",
            "description": "Enable warm color filter",
            "reason": "Night usage detected"
        })

    if "gaming" in req.usage:
        results.append({
            "title": "High Contrast Mode",
            "description": "Improves visibility during gaming",
            "reason": "Gaming usage selected"
        })

    # ---------- FEATURES ----------
    if "image_clarity" in req.features:
        results.append({
            "title": "Enhance Image Clarity",
            "description": "Enable sharp image rendering",
            "reason": "Image clarity feature selected"
        })

    if "text_size" in req.features:
        results.append({
            "title": "Custom Text Scaling",
            "description": "Adjust text size as per comfort",
            "reason": "Text size preference selected"
        })

    if "dark_mode" in req.features:
        results.append({
            "title": "System Dark Mode",
            "description": "Dark UI reduces glare",
            "reason": "Dark mode selected"
        })

    # ---------- FALLBACK ----------
    if not results:
        results.append({
            "title": "Balanced Accessibility Mode",
            "description": "Default accessibility settings applied",
            "reason": "No strong preferences detected"
        })

    return {
        "recommendations": results,
        "disclaimer": "This app provides general accessibility guidance, not medical advice."
    }